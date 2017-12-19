package io.swagger.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.joda.time.DateTime;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Folder.class)
public abstract class Folder_ {

	public static volatile SingularAttribute<Folder, Folder> parent;
	public static volatile ListAttribute<Folder, FolderSubFolders> subFolders;
	public static volatile SingularAttribute<Folder, String> name;
	public static volatile ListAttribute<Folder, File> files;
	public static volatile SingularAttribute<Folder, UUID> id;
	public static volatile SingularAttribute<Folder, String> url;
	public static volatile SingularAttribute<Folder, DateTime> createDate;

}

