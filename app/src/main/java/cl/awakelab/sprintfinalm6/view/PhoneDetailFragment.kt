package cl.awakelab.sprintfinalm6.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.awakelab.sprintfinalm6.databinding.FragmentDetailPhoneBinding
import coil.load


const val ARG_PARAM_ID = "phoneId"

class PhoneDetailFragment : Fragment() {

    lateinit var binding: FragmentDetailPhoneBinding
    private val phoneViewModel: PhoneViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPhoneBinding.inflate(inflater, container, false)
        val phoneId = arguments?.getInt("id")?: 0
        phoneViewModel.getPhoneDetail(phoneId)
        phoneViewModel.phoneDetailLiveData(phoneId).observe(viewLifecycleOwner, Observer { detailPhone ->
            if (detailPhone != null) {
               // binding.tvIDDetail.text = detailPhone.id.toString()
                binding.imageViewItemDetail.load(detailPhone.image)
                binding.tvNameDetail.text = detailPhone.name
                binding.tvPriceDetail.text = "Precio oferta $" + detailPhone.price.toString()
                binding.tvDescriptionDetail.text = detailPhone.description
                binding.tvLastPriceDetail.text = "Precio referencia $" + detailPhone.lastPrice.toString()
                if(!detailPhone.credit){
                    binding.tvCreditDetail.text = "Sólo pago en efectivo"
                }else{
                    binding.tvCreditDetail.text = "Se acepta tarjeta de crédito"
                }
            }

        })
        binding.fabContact.setOnClickListener {
            val contact = "info@novaera.cl"
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            val emailText = "Hola:\nVi este teléfono y me gustaría que me contactaran a este correo o al siguiente número +56984682043"
            val productName = binding.tvNameDetail.text.toString()
            val productId = phoneId
            val subject = "Consulta $productName id $productId"
            val uriText = "mailto:$contact" +
                    "?subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(emailText)
            val uri = Uri.parse(uriText)
            emailIntent.data = uri

            startActivity(Intent.createChooser(emailIntent, "Consultar por producto..."))
        }

        return binding.root
    }


}
