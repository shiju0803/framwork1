**Spring框架学习第二天，注解方式整合mybatis**

注解方式spring整合mybatis

    public class JdbcConfig{
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

		@Bean("dataSource")
		public DataSource dataSource(){
			DruidDataSource dataSource=new DruidDataSource();
			dataSource.setDriverClassName(dirverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			return dataSource;
		}
	}
	
	public class MybatisConfig{	
		@Bean
		public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
			SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
			ssfb.setDataSource(dataSource);
			factoryBean.setTypeAliasesPackage("com.itheima.bean");
			return ssfb;
		}
		
	    @Bean
        public MapperScannerConfigurer mapperScannerConfigurer(){
            //1 创建MapperScannerConfigurer对象
            MapperScannerConfigurer msc=new MapperScannerConfigurer();
            //2 设置参数
            msc.setBasePackage("com.itheima.mapper");
            //3 返回MapperScannerConfigurer对象
            return msc;
        }
	}
	
	@Configuration
	@ComponentScan("com.itheima")
	@PropertySource("classpath:jdbc.properties")
	@Import({JdbcConfig.class,MybatisConfig.class})
	public class SpringConfiguration{
	
	}

**spring整合junit**

    【第一步】添加依赖：junit(必须是4.12及以上版本)、spring-test
    
    【第二步】使用spring中提供的单元测试运行类替换JVM中单元测试运行类
    @RunWith(SpringJUnit4ClassRunner.class)
    
    //【第三步】加载配置文件或者配置类
    @ContextConfiguration(classes = {SpringConfiguration.class}) //加载配置类

    //@ContextConfiguration(locations={"classpath:applicationContext.xml"})//加载配置文件
    public class StudentTest {

    @Autowired
    private UserService userService;

    }