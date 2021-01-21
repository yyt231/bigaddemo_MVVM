package other.mvvm.adapter

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvvm.adapter.app_package.mvvmAdapterKt
import other.mvvm.fragment.res.layout.mvvmFragmentXml


fun RecipeExecutor.mvvmAdapterRecipe(
        moduleData: ModuleTemplateData,
        adapterClass: String,
        layoutName: String,
        packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val mvvmAdapter = mvvmAdapterKt(projectData.applicationPackage, adapterClass, layoutName, packageName)
    // 保存Adapter
    save(mvvmAdapter, srcOut.resolve("${adapterClass}Adapter.${ktOrJavaExt}"))
    // 保存xml
    save(mvvmFragmentXml(packageName, adapterClass), resOut.resolve("layout/${layoutName}.xml"))

}