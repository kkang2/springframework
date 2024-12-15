package com.security.pattern.domain;
import lombok.RequiredArgsConstructor;                    
                                                                                  
import java.security.Principal;                                      
                                                                                  
                                                                                  
@RequiredArgsConstructor                                          
public class CustomUserPrincipal implements Principal {
                                                                                  
  private final String mid;                                              
                                                                                  
  @Override                                                                
  public String getName() {                                          
    return mid;                                                             
  }                                                                              
}                                                                                
