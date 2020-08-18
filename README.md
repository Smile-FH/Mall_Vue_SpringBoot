# Mall_Vue_SpringBoot
仿newbee-mall，学习开发的一个mall

{FINISH}2020年8月10日22点02分：
1. 发现自己管理员端的输入验证都还没做啊
2. 分页功能理解的差不多了，明天上午把分页给搞定。
先用pageUtil来提取处理前端发过来的Map参数，提取出page页数和limit条数，类似与实体类
还有一个查询出来的数据主体pageResult：主要是四个数据：数据总条数，数据主体，总页数，当前页数，每页记录数。
最后返回的是Result，数据主体，响应码，响应信息。
Result还有一个具体的实体类叫做ResultGenerate，封装类，响应码，响应信息，响应主体，接收查询出来的数据主体PageResult

2020年8月12日14点34分记录：
1. 管理员账户个人信息修改页，修改完之后，少了提示框，少了前端控制跳转回登录页
2. SpringBoot后台com.fh.mall.controller.admin.AdminController.modify方法更改完数据之后，返回的不是字符串数据！！！需要在controller注解下返回json数据类型
3. mallUser页面中表格时间数据格式化，表格的前进后退按钮都不显示，还有旁边的滚动条，太难看。
4. 去学习Java中注释的用法，以及TODO的作用
5. 简单的逻辑验证能不能放到前端去？

2020年8月17日22点38分：
获取配置文件中的路径信息一直为空，明天再搞。

2020年8月18日08点40分：
优化：
    \mall\utils\GetUploadPath.java，把其中获得路径的方法给搞成静态的