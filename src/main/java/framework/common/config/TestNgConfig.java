package framework.common.config;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings( {"unchecked", "rawtypes"} )
public class TestNgConfig
{
  private static List<String> includedGroups = new ArrayList();

  private static List<String> excludedGroups = new ArrayList();

  private static List<String> testngConfigs = new ArrayList();

  public static List<String> getIncludedGroups()
  {
    return includedGroups;
  }

  public static void setIncludedGroups( List<String> includedGroupsToSet )
  {
    includedGroups = includedGroupsToSet;
  }

  public static List<String> getExcludedGroups()
  {
    return excludedGroups;
  }

  public static void setExcludedGroups( List<String> excludedGroupsToSet )
  {
    excludedGroups = excludedGroupsToSet;
  }

  public static List<String> getTestngConfigs()
  {
    return testngConfigs;
  }

  public static void addTestngConfig( String testngConfig )
  {
    testngConfigs.add( testngConfig );
  }
}