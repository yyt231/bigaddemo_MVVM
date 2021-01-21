package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mvvm.activity.mvvmActivityTemplate
import other.mvvm.adapter.mvvmAdapterTemplate
import other.mvvm.fragment.mvvmFragmentTemplate

/**
 *
 * @Description:
 * @Author:         杨彦韬
 * @CreateDate:     2021/1/20 10:38
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/1/20 10:38
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
            mvvmActivityTemplate,
            mvvmFragmentTemplate,
            mvvmAdapterTemplate
    )
}