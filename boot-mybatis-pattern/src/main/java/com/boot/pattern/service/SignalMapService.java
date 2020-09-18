package com.boot.pattern.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.boot.pattern.domain.signal.SignalMapBodyProxyDomain;
import com.boot.pattern.mapper.SignalMapMapper;

@Service
public class SignalMapService {
	@Resource SignalMapMapper signalMapMapper;
	
	public SignalMapBodyProxyDomain selectMapInfoCandidate(SignalMapBodyProxyDomain domain) throws Exception {
		return signalMapMapper.selectMapInfoCandidate(domain);
	}
	
	public void insertMapInfoCandidate(SignalMapBodyProxyDomain domain) throws Exception {
		signalMapMapper.insertMapInfoCandidate(domain);
	}
}