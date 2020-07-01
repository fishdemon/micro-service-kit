package code;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author Anjin.Ma
 * @date 2020-6-9
 */
public class CodeGenerator {
	
	public static void main(String[] args) {
		buildConfig();
	}

    public static void buildConfig() {
    	String configFile = "mpcg.config.json";
    	FileReader reader = new FileReader(ClassLoaderUtil.getClassLoader().getResource(configFile).getFile());
    	String configStr = reader.readString();
    	
    	AutoGenerator ag = JSONUtil.toBean(configStr, AutoGenerator.class);
    	ag.setTemplateEngine(new FreemarkerTemplateEngine());
    	ag.execute();
//    	System.out.println(JSONUtil.toJsonPrettyStr(ag.getDataSource()));
//    	System.out.println(JSONUtil.toJsonPrettyStr(ag.getGlobalConfig()));
//    	System.out.println(JSONUtil.toJsonPrettyStr(ag.getPackageInfo()));
//    	System.out.println(JSONUtil.toJsonPrettyStr(ag.getStrategy()));
//    	System.out.println(JSONUtil.toJsonPrettyStr(ag.getTemplate()));
    }

}
