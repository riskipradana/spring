package com.in28minutes.spring.basics.springin5steps.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Component mean that BinarySearchImpl is a bean that managed by spring framework
 * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  mean that new Bean is create every instantiate
 * Use SCOPE_SINGLETON if yout want to get only one instance
 */

//@Component
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {

    private static Logger LOGGER = LoggerFactory.getLogger(BinarySearchImpl.class);

    /**
     * @Autowired mean that SortAlgorithm is dependency of BinarySearchImpl
     * recomended to use this only (without setter or constructor injection)
     *
     * to autowire the dependency can be done by :
     *     method 1 (add @Primary to SortAlgotihm class)
     *     private SortAlgorithm sortAlgorithm
     *     method 2 (Autowiring by name)
     *     private SortAlgorithm sortAlgorithm;
     *     private SortAlgorithm sortAlgorithm;
     *     method 3 (Autowiring by Qualifier with add @Qualifier("qualifier_name"))
     *
     *     setter injection - use if sortAlgorithm is optional dependency
     *     code :
     *     public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
     *         this.sortAlgorithm = sortAlgorithm;
     *     }
     *
     *     constructor injection - use if sortAlgorithm is mandatory dependency
     *     binarySearchImpl cant run without sortAlgorithm
     *     code :
     *     public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
     *         this.sortAlgorithm = sortAlgorithm;
     *     }
     */

    @Autowired
    @Qualifier("bubble")
    private SortAlgorithm sortAlgorithm;

    public int binarySearch(int [] numbers, int numberToSearchFor) {

        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(sortAlgorithm);
        //Search the array
        return 3;
    }

    /**
     * as soon as the bean is created and initialize with dependency,
     * the post construct method would be called
     */

    @PostConstruct
    public void postConstruct(){
        LOGGER.info("postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        LOGGER.info("preDestroy");
    }
}
