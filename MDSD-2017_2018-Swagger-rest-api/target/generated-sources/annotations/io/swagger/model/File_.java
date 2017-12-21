package io.swagger.model;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(File.class)
public abstract class File_ {

	public static volatile SingularAttribute<File, String> ext;
	public static volatile SingularAttribute<File, Folder> parent;
	public static volatile SingularAttribute<File, Date> uploadDate;
	public static volatile SingularAttribute<File, String> name;
	public static volatile SingularAttribute<File, UUID> id;
	public static volatile SingularAttribute<File, String> url;

}

