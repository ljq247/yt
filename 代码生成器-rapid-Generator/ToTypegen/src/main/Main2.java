package main;
import java.io.File;
import java.util.Scanner;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.util.ArrayHelper;
import cn.org.rapid_framework.generator.util.StringHelper;
import cn.org.rapid_framework.generator.util.SystemHelper;
/**
 * 命令行工具类,可以直接运行
 * 
 * @author badqiu
 */
public class Main2 {
	
	public static void main(String[] args) throws Exception {
		//disable freemarker logging
		freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_NONE);
		
		startProcess();
	}

	private static void startProcess() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("templateRootDir:"+new File(getTemplateRootDir()).getAbsolutePath());
		printUsages();
		///改写的程序:
			processLine(sc);
		//
		while(sc.hasNextLine()) {
//			try {
//				processLine(sc);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				Thread.sleep(700);
//				printUsages();
//			}
			Thread.sleep(10000);
		}
	}

	private static void processLine(Scanner sc) throws Exception {
		GeneratorFacade facade = new GeneratorFacade();//初始化配置文件
		//String cmd = sc.next();// 取出一个字符
		String cmd="gen";
		if("gen".equals(cmd)) {
			// 把  [*] 也存起来! 头一个字符去掉空格,后面的不去掉,以数组的形式存储!
			//String[] args = nextArguments(sc);
			String[] args=new String[]{ "*" };
			if(args.length == 0) return;
			
			String includes = getIncludes(args,1);
			facade.g.setIncludes(includes);
			
			
			
			String templateRootDir = getTemplateRootDir();
			////  搜索  [外部获取所有表]  直接定位获取表格 
			//     外部获取所有表
			facade.generateByTable(args[0],templateRootDir); //dubug 进来啊
			
			if(SystemHelper.isWindowsOS) {
				///打开文件夹!
			    Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot").replace('/', '\\'));
			    
			}
		}else if("del".equals(cmd)) {
			//这个不需要删除了!~
			String replace = GeneratorProperties.getRequiredProperty("outRoot").replace('/', '\\');
			System.out.println("文件目录:----"+replace);
			
			String[] args = nextArguments(sc);
			if(args.length == 0) return;
			facade.g.setIncludes(getIncludes(args,1));
			facade.deleteByTable(args[0], getTemplateRootDir());
		}else if("quit".equals(cmd)) {
		    System.exit(0);
		}else {
			System.err.println(" [ERROR] unknow command:"+cmd);
		}
	}

	private static String getIncludes(String[] args, int i) {
		String includes = ArrayHelper.getValue(args, i);
		if(includes == null) return null;
		return includes.indexOf("*") >= 0 || includes.indexOf(",") >= 0 ? includes : includes+"/**";
	}
	
	private static String getTemplateRootDir() {
		return System.getProperty("templateRootDir", "template");
	}

	private static void printUsages() {
		System.out.println("Usage:");
		System.out.println("\tgen table_name [include_path]: generate files by table_name");
		System.out.println("\tdel table_name [include_path]: delete files by table_name");
		System.out.println("\tgen * [include_path]: search database all tables and generate files");
		System.out.println("\tdel * [include_path]: search database all tables and delete files");
		System.out.println("\tquit : quit");
		System.out.println("\t[include_path] subdir of templateRootDir,example: 1. dao  2. dao/**,service/**");
		System.out.print("please input command:");
	}
	
	private static String[] nextArguments(Scanner sc) {
		return StringHelper.tokenizeToStringArray(sc.nextLine()," ");
	}
}
