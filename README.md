springboot + mybatis plus 生成 controller service serviceImpl model dao mapper.xml

#如何生成代码
1. 运行`generate/utils/CodeGenerator`
2. 输入模块名
3. 输入数据表名，需要带前缀
4. 回车生成代码

#注意事项
1. 带模块复制到项目内
2. 需要把`mapper`中的.xml文件copy到 `resources`下相同模块名下。例如你创建的是`user`模块，那么需要复制到`resources/user`下。
3. controller文件里导入`红色代码块需要的包即可`
4. service接口文件里创建分页列表方法`getList`，并且返回值为返回类型为 `List<model名>`
5. service实现文件里建分页列表方法`getList`，具体参考user模块即可
6. 模块目录下新建request文件夹，复制model文件2份到request 重命名为（userRequest和userSearchRequest），删除主键属性即可（不删除的话，在插入的时候要使用 saveOrUpdate方法，意味着如果id有值则更新，没有则插入）


