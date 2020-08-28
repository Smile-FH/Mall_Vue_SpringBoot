# Mall_Vue_SpringBoot
仿newbee-mall，学习开发的一个mall

2020年8月10日22点02分：
- [x] 发现自己管理员端的输入验证都还没做啊
- [x] 分页功能理解的差不多了，明天上午把分页给搞定。
先用pageUtil来提取处理前端发过来的Map参数，提取出page页数和limit条数，类似与实体类
还有一个查询出来的数据主体pageResult：主要是四个数据：数据总条数，数据主体，总页数，当前页数，每页记录数。
最后返回的是Result，数据主体，响应码，响应信息。
Result还有一个具体的实体类叫做ResultGenerate，封装类，响应码，响应信息，响应主体，接收查询出来的数据主体PageResult

2020年8月12日14点34分记录：

- [x] 管理员账户个人信息修改页，修改完之后，少了提示框，少了前端控制跳转回登录页
- [x] SpringBoot后台com.fh.mall.controller.admin.AdminController.modify方法更改完数据之后，返回的不是字符串数据！！！需要在controller注解下返回json数据类型
- [ ] mallUser页面中表格时间数据格式化，表格的前进后退按钮都不显示，还有旁边的滚动条，太难看。
- [x] 去学习Java中注释的用法，以及TODO的作用
- [ ] 简单的逻辑验证能不能放到前端去？

2020年8月17日22点38分：
- [x] 获取配置文件中的路径信息一直为空（08点40分搞定）

2020年8月18日08点40分：
- [x] \mall\utils\GetUploadPath.java，把其中获得路径的方法给搞成静态的

2020年8月18日11点38分：
- [x] 后台管理页面轮播图业务层实现了分页数据查询，持久层5个接口全部能正常运行
- [x] 接下来需要实现剩下的业务层逻辑
- [x] 前端页面的整合

2020年8月22日17点08分：

- [x] 轮播图管理页更新操作时，表格的个别字段隐藏问题
- [x] 表格显示url字段直接显示图片问题，url格式判断问题
- [x] 添加轮播图功能，1. 先实现上传图片的功能（图片后缀判断）

2020年8月23日15点07分：

上午时候把这几天做的例子给学长看了，学长问了一些问题，现在这里记录一下。

1. 写验证码的流程。
2. 登录操作时session和cookie的区别，session和cookie是如何协作的。
3. 什么是请求方式，什么是同源策略，什么是跨域问题，什么是URI、URL、URN。
4. SpringBoot中过滤器、拦截器、aop的关系，及作用时间。
5. SpringBoot中的生命周期
6. Vue中的生命周期

- [x] 接下来去写前端的轮播图展示