# GradlePlugin
Gradle插件定义示例项目

对于Gradle的了解一直处于简单应用到处粘贴复制的状态，正好最近有时间，就找资料恶补了一下，经过反复的修改，写了这么一个Gradle插件实例，没有复杂功能，只是展示一下整个的一个流程。

这个插件是创建在工程中，也有其他的方式来创建，但是流程都应该差不多得。先简单介绍下

1、创键一个model（**buildSrc**）记住一定是buildSrc，这样gradle才能找到它

2、删除buildSrc中的一些文件和目录如下图
   ![buildSrc](http://ww4.sinaimg.cn/large/006HJ39wgy1fehyam34b7j30cf06ht8x.jpg
)

3、建立一个Java包，然后写一个类实现Plugin<Project>接口,只有一个抽象方法

4、在抽象方法中随便写点啥，我就创建了一个属性和一个Task，注意其中的写法
   ```java
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
   ```

5、在Module中引入
   ```groovy
   apply plugin: com.fishpan.plugin.CustomPlugin
   
   //  插件自定的属性
   plugin{
       name "customer Name"
   }
   ```
