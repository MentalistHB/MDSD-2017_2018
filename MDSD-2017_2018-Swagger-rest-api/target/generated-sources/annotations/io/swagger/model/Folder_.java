package io.swagger.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Folder.class)
public abstract class Folder_ {

	public static volatile SingularAttribute<Folder, String> parent;
	public static volatile SingularAttribute<Folder, String> path;
	public static volatile ListAttribute<Folder, Folder> subFolders;
	public static volatile SingularAttribute<Folder, String> name;
	public static volatile ListAttribute<Folder, File> files;
	public static volatile SingularAttribute<Folder, String> id;
	public static volatile SingularAttribute<Folder, String> url;
	public static volatile SingularAttribute<Folder, Date> createDate;

}

