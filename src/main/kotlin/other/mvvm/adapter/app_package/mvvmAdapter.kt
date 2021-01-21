package other.mvvm.adapter.app_package

fun mvvmAdapterKt(
        applicationPackage: String?,
        adapterClass: String,
        layoutName: String,
        packageName: String
) = """
import android.content.Context
import com.shide.baselib.adapter.SimpleRecAdapter
import ${applicationPackage}.databinding.Item${adapterClass}Binding
import ${applicationPackage}.R
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
// TODO ----替换实体类
class ${adapterClass}Adapter(context: Context?) :
    SimpleRecAdapter<-----, ${adapterClass}Adapter.MyViewHolder, Item${adapterClass}Binding>(context) {


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //记得替换
        TODO("holder.binding.orderInfo = data.get(position)")
     
    }

    override fun newViewHolder(viewType: Int, itemView: Item${adapterClass}Binding?): MyViewHolder {
        return MyViewHolder(itemView!!)
    }

    override fun getLayoutId(): Int {
        return R.layout.${layoutName}
    }

    override fun initViewDataBinding(
        inflater: LayoutInflater?,
        layout: Int,
        parent: ViewGroup?,
        attachToParent: Boolean?
    ): Item${adapterClass}Binding {
        return DataBindingUtil.inflate(inflater!!, layoutId, parent, false)
    }

    class MyViewHolder(itemView: Item${adapterClass}Binding) :
        RecyclerView.ViewHolder(itemView.getRoot()) {
        val binding: Item${adapterClass}Binding

        init {
            this.binding = itemView
        }
    }
}
"""