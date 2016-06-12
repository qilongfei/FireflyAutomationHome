package practicetwo.launch;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {

	public WebDriver driver = null;
	private FirefoxProfile firefoxprofile = null;
	private static DesiredCapabilities caps = null;
	private String projectpath ="E:\\autotest\\workspace\\FireflyAutomation\\trunk";

	
	public Browsers(BrowsersType browserstype){
		switch(browserstype){
		    case firefox:
		    	File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
			    File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
				firefoxprofile =  new FirefoxProfile();
				try {
					firefoxprofile.addExtension(firebug);
					firefoxprofile.addExtension(firepath);
					firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
					firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
					//使用profile
				    //ProfilesIni allProfiles = new ProfilesIni();
				    //FirefoxProfile profile = allProfiles.getProfile("default");
				    //driver = new FirefoxDriver(profile);
					
					// 使用代理
					//profile.setPreference(“network.proxy.type”, 1);

					// http协议代理配置
					//profile.setPreference(“network.proxy.http”, proxyIp);
					//profile.setPreference(“network.proxy.http_port”, proxyPort);

					// 所有协议公用一种代理配置，如果单独配置，这项设置为false，再类似于http的配置
					//profile.setPreference(“network.proxy.share_proxy_settings”, true);

					// 对于localhost的不用代理，这里必须要配置，否则无法和webdriver通讯
					//profile.setPreference(“network.proxy.no_proxies_on”, “localhost”);

					// 以代理方式启动firefox
					//FirefoxDriver ff  = new FirefoxDriver(profile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//如果firefox没有安装在c盘需要执行下面这句，否则请注释掉
				//System.setProperty("webdriver.firefox.bin", "c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
		    case ie:	
		    	System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer32.exe"); 
				caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
				caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);   
				caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");		
		        caps.setCapability("ignoreZoomSetting", true);
		        driver = new InternetExplorerDriver(caps);
		        driver.manage().window().maximize();
		        break;
		    case chrome:
				System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver.exe"); 
				caps = DesiredCapabilities.chrome();
				caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));  //���browser
				//capabilities.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //���ô���
				driver = new ChromeDriver(caps);
				driver.manage().window().maximize();
				break;
		}
		
			
	}
}
