package cl.awakelab.sprintfinalm6.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.sprintfinalm6.R
import cl.awakelab.sprintfinalm6.data.local.PhoneEntity
import cl.awakelab.sprintfinalm6.databinding.ItemPhoneBinding
import coil.load
import cl.awakelab.sprintfinalm6.view.PhonesAdapter

/*
[x] Item Layout
[x] Agregar constraint
[x] Implementar clase Adapter
[x] Heredar RecyclerView.Adapter
[x] Crear clase anidada ViewHolder, que hereda de la clase ViewHolder
[x] Agregar constructor (implement members)
[x] Crear objeto, data class
[x] Crear lista
[] Asignar tamaño de la lista en getItemCount
[x] Definir Binding Class del Item
[x] Cambiar View por el binding
[] Declarar variable item en onBindViewHolder
[] Implementar binding en clase ViewHolder
[] Adapter + ViewHolder
[] Obtener los datos
*/

class PhonesAdapter : RecyclerView.Adapter<PhonesAdapter.PhoneViewHolder>() {

    lateinit var binding: ItemPhoneBinding
    private var phoneList = mutableListOf<PhoneEntity>()
    private var onItemClickListener: ((PhoneEntity) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
       binding = ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhoneViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = phoneList[position]
        holder.bind(phone)
    }

    fun setData(phone: List<PhoneEntity>){
        this.phoneList.clear()
        this.phoneList.addAll(phone)
        notifyDataSetChanged()
    }

    inner class PhoneViewHolder(val phonesViews: ItemPhoneBinding): RecyclerView.ViewHolder(phonesViews.root) {
        fun bind(phone: PhoneEntity){

           // phonesViews.tvID.text = phone.id.toString()
            phonesViews.tvName.text = phone.name
            phonesViews.tvPrice.text = "$" + phone.price.toString()
            phonesViews.imageViewItem.load(phone.image)
            phonesViews.cvItemPhone.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("id", phone.id)
                Navigation.findNavController(phonesViews.root).navigate(R.id.action_listFragment_to_phoneDetailFragment, bundle)
            }

        }

    }

}