package other.mvvm.adapter

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API


val mvvmAdapterTemplate
    get() = template {
        revision = 1
        name = "MVVM Adapter"
        description = "适用于BigaDemoMVVM框架的Adapter"
        minApi = MIN_API
        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        lateinit var layoutName: StringParameter

        val adapterClass = stringParameter {
            name = "Adapter Name"
            default = "Main"
            help = "只输入名字，不要包含Adapter"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "item_layout_name"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "item_${camelCaseToUnderlines(adapterClass.value)}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
                TextFieldWidget(adapterClass),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageName)
        )

        recipe = { data: TemplateData ->
            mvvmAdapterRecipe(
                    data as ModuleTemplateData,
                    adapterClass.value,
                    layoutName.value,
                    packageName.value)
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }