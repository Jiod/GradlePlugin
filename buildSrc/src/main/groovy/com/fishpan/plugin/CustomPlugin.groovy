package com.fishpan.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 自定义插件，实现Plugin接口即可，在build.gradle引用
 */
class CustomPlugin implements Plugin<Project>{
    @Override
    void apply(Project target) {
        //  创建一个属性
        target.extensions.create("plugin", com.fishpan.plugin.PluginExtension)

        //  创建一个任务
        target.tasks.create("Test") << {
            //  打印前面创建的属性，注意这里一定要写上target，不然执行的时候会提示找不到属性plugin
            println target.plugin.name
        }
    }
}