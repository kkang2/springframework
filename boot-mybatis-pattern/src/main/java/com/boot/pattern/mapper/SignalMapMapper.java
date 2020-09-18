package com.boot.pattern.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.boot.pattern.domain.signal.SignalMapBodyDomain;
import com.boot.pattern.domain.signal.SignalMapBodyProxyDomain;

@Repository
@Mapper
public interface SignalMapMapper {
	public SignalMapBodyProxyDomain selectMapInfoCandidate(SignalMapBodyProxyDomain domain) throws Exception;
	public void insertMapInfoCandidate(SignalMapBodyProxyDomain domain) throws Exception;
}