# Mall_Vue_SpringBoot
仿newbee-mall，学习开发的一个mall

2020年8月30日19点45分：  
1. 数据库添加测试数据
2. 制作token
3. [制作Token过程中的数字签名和数字证书是什么](http://www.ruanyifeng.com/blog/2011/08/what_is_a_digital_signature.html)
4. [什么是摘要算法，摘要算法和加密算法的关系,摘要算法，数字签名，数字证书等的关系](https://www.jianshu.com/p/47a8498e47d0)
5. [分层领域模型](https://juejin.im/post/6844903636334542856#heading-1)
6. [为什么用自定义参数解析器？]()
7. [spring mvc自定义参数解析器](https://blog.csdn.net/guanzhengyinqin/article/details/85255840)
8. [什么是RESTful风格，他和传统的开发相比有什么不同，为啥出现了这种风格？](https://www.jianshu.com/p/91600da4df95)
9. [简单了解RESTful风格下HTTP的响应码意义](https://www.jianshu.com/p/7893169a7c93)
10. [Apache之HTTP协议,此部分还需要去详细了解一下才行](https://blog.51cto.com/shjia/1432670)
11. [自定义注解的基本概念](https://blog.csdn.net/luckykapok918/article/details/79290109)
12. [springBoot自定义注解,以及aop和自定义注解的使用](https://www.zhihu.com/question/24863332)
13. 自定义注解参数含义  
![自定义注解中的注解参数含义](src/main/resources/static/admin/plugins/flag-icon-css/flags/4x3/自定义注解中的注解参数含义.png)
14. [RuntimeException和Exception的区别是啥？](https://zhuanlan.zhihu.com/p/47258269)
15. [Swagger非全局、无需重复输入header参数配置](https://www.jianshu.com/p/6e5ee9dd5a61)
16. [Swagger注解详解](https://blog.csdn.net/xiaojin21cen/article/details/78654652)
17. Swagger的多模块配置方法1. 在配置文件中创建多个Docket。2. 根据源码自己写方法去 遍历目录，spring could项目的多模块配置可以瞅瞅
18. [equals时候，变量放在前后的区别](https://blog.csdn.net/zhaoxiangjun_/article/details/77093294)
19. [Spring Boot中使用Swagger2异常：Illegal DefaultValue 0 for parameter type integer](https://cloud.tencent.com/developer/article/1600539)
20. [Swagger分组](https://blog.csdn.net/sinat_35626559/article/details/104920802)
21. [SpringBoot全局异常处理](https://www.cnblogs.com/fishpro/p/spring-boot-study-throwable.html#_label2)
22. [JS中location.hostname和location.host区别](http://www.5idev.com/p-javascript_location_hostname.shtml)
23. [java中的正则Pattern和Matcher](https://blog.csdn.net/yin380697242/article/details/52049999)

2020年9月25日22点17分：  
最近因为开发别的项目有点耽误，今天开始搞起来，  
先来记录一个问题
1. [window.location得到的信息问题](https://www.cnblogs.com/zhabayi/p/6419938.html)
![window.location](src/main/resources/static/admin/plugins/flag-icon-css/flags/4x3/image.png)
2. [js 截取字符问题](https://www.jb51.net/article/42482.htm)
3. [jQuery中的ajax](https://www.cnblogs.com/tylerdonet/p/3520862.html)

2020年9月28日08点01分：  
在开发中发现一个问题，查询到的数据总页数有点不对劲，后面再说吧

2020年10月1日15点26分：
1. [## jQuery中监听事件一般都是用on来监听 ##]()

2020年10月3日09点21分：
1. [Jquery中报错 Cannot read property 'toLowerCase' of undefined，  
一般是使用`$(name)`时传name值错了)](https://qiita.com/BRSF/items/4f4e39bd82778b976392)
2. [## Java注解中的属性动态赋值问题：代码质量优化 ##]()
3. [数据库建表时先建一个只有字段名的空表，然后在空表的基础上去改]()
4. [Law Of Demeter(最少知识原则) Wiki](https://en.wikipedia.org/wiki/Law_of_Demeter)
5. [Java Law Of Demeter Java Examples](https://alvinalexander.com/java/java-law-of-demeter-java-examples/#:~:text=The%20Law%20of%20Demeter%20for%20functions%20requires%20that,in%20the%20scope%20of%20M.%20Head%20First%20Java.)

2020年10月4日11点18分：  
[## jquery ##]()和[## bootstrap ##]()的知识抽空也得看看
1. [bootstrap------栅格系统](https://getbootstrap.com/docs/4.4/layout/grid/)
2. [Bootstrap------边距问题](https://getbootstrap.com/docs/4.4/utilities/spacing/)
3. [Bootstrap------flex布局问题](https://getbootstrap.com/docs/4.4/utilities/flex/)
4. [## AdminLTE中的swatch开关拿值问题 ##]()
5. [## Jquery `$().val()` 作用及用法 ##]()
6. [## 前端有没有事务控制，也就是说，有没有一种机制使得连续的请求能合并到一步去执行的 ##]()

2020年10月5日08点22分：
1. [## 箭头函数和原始函数的区别是啥？##]()
2. [## bootstrap自定义属性走一波 ##]()
3. [## bootstrap模态框瞅瞅吧，不然都不知道是啥东西 ##]()
4. 前端页面source中没有需要的文件时，要怎么办
   1. 检查代码中的编译包中有没有该文件，如果没有则是因为项目编译不完全，需要重新编译。
   2. 检查代码中该页面是否具有相关的页面js引入
5. [Thymeleaf中if和unless用法](https://blog.csdn.net/u014374009/article/details/104267168)
- [ ] 不舒服的地方：商品信息编辑的时候应该给上传图片单独的块来搞，不应该隐藏到模态框中。

2020年10月6日18点18分：
1. [js的for循环中出现异步函数，回调引用的循环值总是最后一步的值？](https://www.cnblogs.com/csuwujing/p/8021913.html)
2. [关于JS的for循环包裹异步函数的问题](https://www.jianshu.com/p/690f58a3ff7b)
3. [## maven插件的原理及mvn spring-boot:run命令的执行过程 ##]()
4. [## js判断包含字符和截取字符串功能是不一样的 ##]()
5. [## JAVA中ResourceBundle：用来解决国际化本地化问题 ##]()

2020年10月8日17点32分：
1. [## 关于mvc地址映射带参数(路径参数)问题 ##]()
2. [## 关于thymeleaf中的某些属性th:block, th:unless, th:utext ##]()
3. [## 拿到商品信息的id之后应该怎么取显示它的分类 ##]()

2020年10月9日19点55分：
1. [## WebMvcConfigurer拦截原理 ##]()

2020年10月12日16点16分：
1. [java8新特性之`.stream().map().collect()`能干啥](https://www.cnblogs.com/javagg/p/12660957.html)
2. [java8之给流中的数据进行分组]()
3. [Java基础系列-Collector和Collectors](https://www.jianshu.com/p/7eaa0969b424)
4. [Java基础系列-Stream](https://www.jianshu.com/p/7eaa0969b424)

2020年10月13日16点50分：  
前台分类页的数据接口虽然写好了，但是还是得优化啊，代码太长不容易阅读

2020年10月24日20点41分：  
前几天敲代码有点烦躁，就去看了看别的知识点，学了点redis，数据结构，linux，不能说完全掌握但是都能用，从现在开始继续搞代码
1. [## 使用`hutool`java工具包进行优化 ##]()