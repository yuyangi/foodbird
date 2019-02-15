package com.foodbird.generate.dynamic.component;

import com.alibaba.fastjson.parser.ParserConfig;
import com.foodbird.generate.dynamic.annotations.processors.FBAnnotationProcessorFactory;
import com.foodbird.generate.dynamic.annotations.processors.FBIAnnotationProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author yuyangi
 * @date
 * @prject com.foodbird.com
 */
@Component
public class FBBeanRegistrator implements BeanDefinitionRegistryPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FBBeanRegistrator.class);

    private BeanDefinitionRegistry registry;

    private FBIAnnotationProcessor annotationProcessor;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        this.registry = registry;
    }

    /**
     * 加载根目录下和名称包含config目录下的*.properties文件
     *
     * @return Resources
     */
    private Resource[] loadResources() {
        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getPath();
        File base = new File(path);
        List<Resource> resources = new ArrayList<>();
        if (base.isDirectory()) {
            File[] propertiesFiles = base.listFiles(pathname -> (pathname.isFile() && pathname.getName().endsWith(".properties"))
                    || (pathname.isDirectory() && pathname.getName().toLowerCase().contains("config")));
            if (propertiesFiles != null && propertiesFiles.length > 0) {
                for (File propertyFile : propertiesFiles) {
                    if (propertyFile.isFile()) {
                        resources.add(new FileSystemResource(propertyFile));
                    } else if (propertyFile.isDirectory()) {
                        File[] subFiles = propertyFile.listFiles(pathname -> pathname.isFile() && pathname.getName().endsWith(".properties"));
                        if (subFiles != null)
                            for (File subFile : subFiles) {
                                resources.add(new FileSystemResource(subFile));
                            }
                    }
                }
            }
        }
        return resources.toArray(new Resource[0]);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        annotationProcessor = FBAnnotationProcessorFactory.create(beanFactory, registry);
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(beanName -> annotationProcessor.process(beanName));
    }

}
