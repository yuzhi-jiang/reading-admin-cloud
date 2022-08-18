package com.yefeng.adminaccount.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.yefeng.adminaccount.dao")
public class MybatisPlusConfig {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }

//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("bookCenterDataSource") DataSource dataSource) throws Exception {
//        // 设置数据源
//        // SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//        //使用mybatis-plus
//        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
//        factory.setDataSource(dataSource);
//        System.out.println("getConnection"+dataSource.getConnection());
//
//        System.out.println("dataSource:");
//        System.out.println(dataSource);
//        // 添加XML映射
//
//
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
//
//        //添加插件
//        factory.setPlugins(this.mybatisPlusInterceptor());
//        SqlSessionFactory sqlSessionFactory = factory.getObject();
//
//        System.out.println(sqlSessionFactory);
//        return sqlSessionFactory;
//    }
//    @Bean(name = "bookCenterSqlSessionTemplate")
//    public SqlSessionTemplate setSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
