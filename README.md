关于小曾oj系统介绍
技术栈：springboot+springcloud+mybaticplus+java-docker+模板方法设计模式+工厂设计模式
功能点：
对用户信息的crud
对题目信息的crud
对判题信息的crud
自主实现原生态代码沙箱的开发
通过java-docker技术实现docker运行用户代码，提高系统的安全性
项目亮点：
通过阅读并借鉴已有oj系统，自主实现了对于用户提交的代码进行编译执行。
通过阅读java-docker官方文档，实现了使用java对docker进行远程开发，拉取进行，创建容器，启动容器等操作。
根据调用接口的安全性问题，使用了简单的请求头密钥传输保证接口的安全性。
使用策略模式进行判题服务的开发，根据不同语言有不同的判题规则（运行时间，内存使用等）
使用模板方法模式对代码沙箱功能进行优化，减少了冗余代码，提高了代码的复用性。
使用工厂模式设计判题沙箱的管理，根据用户配置文件中的沙箱类型使用不同的沙箱环境。
