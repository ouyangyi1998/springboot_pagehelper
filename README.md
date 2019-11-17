# springboot+mybatis+druid多数据源+pagehelper 
- 原代码 https://github.com/xuwujing/springBoot-study
- 两个数据源通过分别在application.properties中配置注入数据，datasource.type选择druid，minIdle（最小空闲） maxActive （最大活跃）maxWait（最大等待时间）
- 目前Spring Boot中默认支持的连接池有dbcp,dbcp2, tomcat, hikari三种连接池。由于Druid暂时不在Spring Boot中的直接支持，故需要进行配置信息的定制
  - timeBetweenEvictionRunsMillis 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
  - minEvictableIdleTimeMillis 配置一个连接在池中最小生存的时间，单位是毫秒
  - validationQuery属性：用来验证数据库连接的语句，这个语句至少是返回一条数据的查询语句 mysql为select 1
  - testOnBorrow = "false"   借出连接时不要测试，否则很影响性能
  - testWhileIdle = "true"   指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去
  - poolPreparedStatements=true 打开ps缓存
  - 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙 spring.datasource.druid.filters=stat,wall,log4j
  - 通过connectProperties属性来打开mergeSql功能；慢SQL记录 spring.datasource.druid.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
- 日志记录器(Logger)是日志处理的核心组件。log4j具有5种正常级别(Level)。
  - DEBUG Level指出细粒度信息事件对调试应用程序是非常有帮助的,一般认为比较重要的方法执行需要详细查看运行情况的则开启debug。
  - INFO level表明消息在粗粒度级别上突出强调应用程序的运行过程，只需要了解该方法是否运行的可以使用INFO
  - WARN level表明会出现潜在错误的情形
  - ERROR level指出虽然发生错误事件，但仍然不影响系统的继续运行。一般异常处理等情况都需要ERROR
  - FATAL level指出每个严重的错误事件将会导致应用程序的退出
- @Mapper 通过注解@Mapper，实现mybatis注解，构造实现类让其他类可以引用。 @MapperScan 在application配置，扫mapper，就无需@Mapper了。
- 项目的继承关系 
  - DAO层 BaseDao<T>-StudentDao extends BaseDao<Student>(UserDao extends BaseDao<User>)
  - service层 BaseService<T>-StudentService extends BaseService<Student>(UserService extends BaseService<User>)
  - service层 BaseService<T>- abstract BaseServiceImpl<T>(abstract getMapper())-StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService
- 多数据源开发 
  - @MapperScan扫描mapper，构造DruidDataSource注入配置文件,配置DataSourceTransactionManager开启spring事务 
  - @Primary可以确定默认首选的bean
- druid监控服务
  - 构造ServletRegistrationBean ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*"); 配置监控页面
  - "allow" "deny" 对于ip访问进行控制+设置登录监控账号与密码
  - 添加过滤规则 filterRegistrationBean.addUrlPatterns("/*");
  - 添加不需要忽略的格式信息 filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
- pagehelper配置
  - 构造pagehelper和properties，注入分页数据库helperDialect:mysql 
  - 是否将参数offset作为PageNum使用,properties.setProperty("offsetAsPageNum", "true");
  - 是否进行count查询,properties.setProperty("rowBoundsWithCount", "true");
  - return pagehelper
- mybatis 可以设置<parametermap> 和 <sql>(简化要搜索的数据，后面可以直接导入)
  - <sql id="test"> <include refid="test">导入数据
  - 利用<where> 代替 where 1=1。。。
