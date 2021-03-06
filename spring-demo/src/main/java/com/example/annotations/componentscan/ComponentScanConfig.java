package com.example.annotations.componentscan;

import com.example.annotations.bean.Person;
import com.example.annotations.componentscan.custom.CustomerTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * *                            _ooOoo_
 * *                           o8888888o
 * *                           88" . "88
 * *                           (| -_- |)
 * *                            O\ = /O
 * *                        ____/`---'\____
 * *                      .   ' \\| |// `.
 * *                       / \\||| : |||// \
 * *                    / _||||| -:- |||||- \
 * *                       | | \\\ - /// | |
 * *                     | \_| ''\---/'' | |
 * *                      \ .-\__ `-` ___/-. /
 * *                   ___`. .' /--.--\ `. . __
 * *                ."" '< `.___\_<|>_/___.' >'"".
 * *               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * *                 \ \ `-. \_ __\ /__ _/ .-` / /
 * *         ======`-.____`-.___\_____/___.-`____.-'======
 * *                            `=---='
 * *
 * *         .............................................
 * *                  佛祖保佑             永无BUG
 * *          佛曰:
 * *                  写字楼里写字间，写字间里程序员；
 * *                  程序人员写程序，又拿程序换酒钱。
 * *                  酒醒只在网上坐，酒醉还来网下眠；
 * *                  酒醉酒醒日复日，网上网下年复年。
 * *                  但愿老死电脑间，不愿鞠躬老板前；
 * *                  奔驰宝马贵者趣，公交自行程序员。
 * *                  别人笑我忒疯癫，我笑自己命太贱；
 * *                  不见满街漂亮妹，哪个归得程序员？
 *
 * @Author:shixianqing
 * @Date:2019/9/1 18:10
 * @Description:
 * includeFilters时，useDefaultFilters = false
 * excludeFilters时，useDefaultFilters = true，将所有bean扫描到，然后从中剔除要过滤的bean
 * for (TypeFilter tf : this.excludeFilters) {
 * 			if (tf.match(metadataReader, getMetadataReaderFactory())) {
 * 				return false;
 * 			}
 * 		}
 * 		for (TypeFilter tf : this.includeFilters) {
 * 			if (tf.match(metadataReader, getMetadataReaderFactory())) {
 * 				return isConditionMatch(metadataReader);
 * 			}
 * 		}
 **/
@Configuration
//@ComponentScan(basePackages = {"com.example.annotations"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class})}
////,includeFilters = {@ComponentScan.Filter(type = FilterType./**/ANNOTATION,classes = {Service.class})},useDefaultFilters = false
//)
@ComponentScan(basePackages = {"com.example.annotations"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {CustomerTypeFilter.class})},
        useDefaultFilters = false
)
public class ComponentScanConfig {

    @Bean
    public Person person(){

        return new Person();
    }
}
