package com.github.shepherdxie.jocker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Shepherd Xie
 * @since 2024/1/29
 */
@Data
public class DockerInfo {
//    @JsonProperty("ID")
    private String id;

    @JsonProperty("Containers")
    private int containers;

    @JsonProperty("ContainersRunning")
    private int containersRunning;

    @JsonProperty("ContainersPaused")
    private int containersPaused;

    @JsonProperty("ContainersStopped")
    private int containersStopped;

    @JsonProperty("Images")
    private int images;

    @JsonProperty("Driver")
    private String driver;

    @JsonProperty("DriverStatus")
    private List<String[]> driverStatus;

    @JsonProperty("Plugins")
    private Map<String, Object> plugins;

    @JsonProperty("MemoryLimit")
    private boolean memoryLimit;

    @JsonProperty("SwapLimit")
    private boolean swapLimit;

    @JsonProperty("CpuCfsPeriod")
    private boolean cpuCfsPeriod;

    @JsonProperty("CpuCfsQuota")
    private boolean cpuCfsQuota;

    @JsonProperty("CPUShares")
    private boolean cpuShares;

    @JsonProperty("CPUSet")
    private boolean cpuSet;

    @JsonProperty("PidsLimit")
    private boolean pidsLimit;

    @JsonProperty("IPv4Forwarding")
    private boolean ipv4Forwarding;

    @JsonProperty("BridgeNfIptables")
    private boolean bridgeNfIptables;

    @JsonProperty("BridgeNfIp6tables")
    private boolean bridgeNfIp6tables;

    @JsonProperty("Debug")
    private boolean debug;

    @JsonProperty("NFd")
    private int nFd;

    @JsonProperty("OomKillDisable")
    private boolean oomKillDisable;

    @JsonProperty("NGoroutines")
    private int nGoroutines;

    @JsonProperty("SystemTime")
    private String systemTime;

    @JsonProperty("LoggingDriver")
    private String loggingDriver;

    @JsonProperty("CgroupDriver")
    private String cgroupDriver;

    @JsonProperty("CgroupVersion")
    private String cgroupVersion;

    @JsonProperty("NEventsListener")
    private int nEventsListener;

    @JsonProperty("KernelVersion")
    private String kernelVersion;

    @JsonProperty("OperatingSystem")
    private String operatingSystem;

    @JsonProperty("OSVersion")
    private String osVersion;

    @JsonProperty("OSType")
    private String osType;

    @JsonProperty("Architecture")
    private String architecture;

    @JsonProperty("IndexServerAddress")
    private String indexServerAddress;

    @JsonProperty("RegistryConfig")
    private RegistryConfig registryConfig;

    @JsonProperty("NCPU")
    private int nCPU;

    @JsonProperty("MemTotal")
    private long memTotal;

    @JsonProperty("GenericResources")
    private Object genericResources;

    @JsonProperty("DockerRootDir")
    private String dockerRootDir;

    @JsonProperty("HttpProxy")
    private String httpProxy;

    @JsonProperty("HttpsProxy")
    private String httpsProxy;

    @JsonProperty("NoProxy")
    private String noProxy;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Labels")
    private String[] labels;

    @JsonProperty("ExperimentalBuild")
    private boolean experimentalBuild;

    @JsonProperty("ServerVersion")
    private String serverVersion;

    @JsonProperty("Runtimes")
    private Map<String, Object> runtimes;

    @JsonProperty("DefaultRuntime")
    private String defaultRuntime;

    @JsonProperty("Swarm")
    private Swarm swarm;

    @JsonProperty("LiveRestoreEnabled")
    private boolean liveRestoreEnabled;

    @JsonProperty("Isolation")
    private String isolation;

    @JsonProperty("InitBinary")
    private String initBinary;

    @JsonProperty("ContainerdCommit")
    private Commit containerdCommit;

    @JsonProperty("RuncCommit")
    private Commit runcCommit;

    @JsonProperty("InitCommit")
    private Commit initCommit;

    @JsonProperty("SecurityOptions")
    private String[] securityOptions;

    @JsonProperty("CDISpecDirs")
    private String[] cdiSpecDirs;

    @JsonProperty("Warnings")
    private String[] warnings;
}
