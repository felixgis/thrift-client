package com.probe.rpc.thrift.client.loadbalancer;

import com.probe.rpc.thrift.client.common.ThriftServerNode;

public interface IRule {

    ThriftServerNode choose(String key);

    void setLoadBalancer(ILoadBalancer lb);

    ILoadBalancer getLoadBalancer();

}
