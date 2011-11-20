/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugins.springsocial.service

import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.UserProfile
import org.springframework.social.connect.ConnectionFactoryLocator
import org.springframework.social.connect.Connection
import org.springframework.util.MultiValueMap

class SpringSocialService {
  def springSecurityService
  ConnectionRepository connectionRepository
  ConnectionFactoryLocator connectionFactoryLocator

  static transactional = false

  /**
   *@see org.springframework.social.connect.ConnectionFactoryLocator#registeredProviderIds()
   */
  Set<String> registeredProviderIds() {
    connectionFactoryLocator.registeredProviderIds()
  }

  /**
   * @see org.springframework.social.connect.ConnectionRepository#findAllConnections()
   */
  MultiValueMap<String, Connection<?>> findAllConnections() {
    verifyCurrentUser()
    connectionRepository.findAllConnections()
  }

  Boolean isCurrentUserConnectedTo(String providerId) {
    //verifyCurrentUser()
    connectionRepository.findConnections(providerId).size()
  }

  /**
   * @see org.springframework.social.connect.ConnectionRepository#findConnections(String)
   */
  List<UserProfile> getUserProfile(String providerId) {
    verifyCurrentUser()
    connectionRepository.findConnections(providerId)*.fetchUserProfile()
  }

  private void verifyCurrentUser() {
     if(!springSecurityService.isLoggedIn()) {
      throw new IllegalStateException("There is no current user loggedId")
    }
  }
}
