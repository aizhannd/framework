package framework.common.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.kohsuke.args4j.Option;

public class Settings {
	@Option(name = "--testng", usage = "Set path to testng.xml file", required = true)
	public String pathToTestng;

	@Option(name = "--login", usage = "Set connection user login", required = false)
	public String login;

	@Option(name = "--password", usage = "Set connection user password")
	public String password;

	@Option(name = "--url", usage = "Set connection url")
	public String url;

	@Option(name = "--driver", usage = "Browser type", required = true)
	public String driver;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
}
