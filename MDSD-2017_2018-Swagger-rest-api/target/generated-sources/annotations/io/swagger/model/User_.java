package io.swagger.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> id;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, Folder> home;
	public static volatile SingularAttribute<User, String> token;

}

