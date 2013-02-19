CREATE TABLE `o_address_books` (                                
 `id` int(11) NOT NULL AUTO_INCREMENT,                       
 `user_id` int(11) DEFAULT NULL,                             
 `status` varchar(1) DEFAULT NULL,                           
 `email` varchar(255) NOT NULL,                              
 `mobile` varchar(255) DEFAULT NULL,                         
 `name` varchar(255) DEFAULT NULL,                           
 `create_time` datetime DEFAULT NULL,                        
 `description` text,                                         
 `ismember` tinyint(1) DEFAULT NULL,                         
 `msn` varchar(255) DEFAULT NULL,                            
 `qq` varchar(255) DEFAULT NULL,                             
 `company_name` varchar(255) DEFAULT NULL,                   
 `function` varchar(255) DEFAULT NULL,                       
 `company_address` varchar(255) DEFAULT NULL,                
 `company_code` varchar(255) DEFAULT NULL,                   
 `company_tel` varchar(255) DEFAULT NULL,                    
 `company_fax` varchar(255) DEFAULT NULL,                    
 `home_address` varchar(255) DEFAULT NULL,                   
 `home_code` varchar(255) DEFAULT NULL,                      
 `home_tel` varchar(255) DEFAULT NULL,                       
 `im_1` varchar(255) DEFAULT NULL,                           
 `im_2` varchar(255) DEFAULT NULL,                           
 `im_3` varchar(255) DEFAULT NULL,                           
 `blog` varchar(255) DEFAULT NULL,                           
 `page` varchar(255) DEFAULT NULL,                           
 `birthday` varchar(255) DEFAULT NULL,                       
 `im_1_type` varchar(255) DEFAULT NULL,                      
 `im_2_type` varchar(255) DEFAULT NULL,                      
 `im_3_type` varchar(255) DEFAULT NULL,                      
 `a_user_id` int(11) DEFAULT NULL,                           
 `invite_flag` tinyint(1) DEFAULT '0',                       
 `is_friend` tinyint(1) DEFAULT '0',                         
     PRIMARY KEY (`id`),                                         
     KEY `index_address_books_on_user_id` (`user_id`)            
   ) ENGINE=InnoDB AUTO_INCREMENT=20466882 DEFAULT CHARSET=utf8;
   
   
CREATE TABLE `o_address_books` (                                          
 `user_id` int(11) DEFAULT NULL,                             
 `email` varchar(255) NOT NULL,                              
 `create_time` datetime DEFAULT NULL,                                      
     PRIMARY KEY (`user_id`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;