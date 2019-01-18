package com.probe.rpc.thrift.client;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;

public abstract class ProbeFactoryImportSelector<T>
		implements DeferredImportSelector, BeanClassLoaderAware, EnvironmentAware {

	private ClassLoader beanClassLoader;

	private Class<T> annotationClass;

	private Environment environment;

	private final Log log = LogFactory.getLog(ProbeFactoryImportSelector.class);

	@SuppressWarnings("unchecked")
	protected ProbeFactoryImportSelector() {
		this.annotationClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(this.getClass(),
				ProbeFactoryImportSelector.class);
	}

	@Override
	public String[] selectImports(AnnotationMetadata metadata) {
		if (!isEnabled()) {
			return new String[0];
		}
		AnnotationAttributes attributes = AnnotationAttributes
				.fromMap(metadata.getAnnotationAttributes(this.annotationClass.getName(), true));

		Assert.notNull(attributes, "No " + getSimpleName() + " attributes found. Is " + metadata.getClassName()
				+ " annotated with @" + getSimpleName() + "?");

		List<String> factories = new ArrayList<>(new LinkedHashSet<>(
				SpringFactoriesLoader.loadFactoryNames(this.annotationClass, this.beanClassLoader)));

		if (factories.isEmpty() && !hasDefaultFactory()) {
			throw new IllegalStateException("Annotation @" + getSimpleName()
					+ " found, but there are no implementations. Did you forget to include a starter?");
		}

		if (factories.size() > 1) {
			log.warn("More than one implementation " + "of @" + getSimpleName()
					+ " (now relying on @Conditionals to pick one): " + factories);
		}

		return factories.toArray(new String[factories.size()]);
	}

	protected boolean hasDefaultFactory() {
		return false;
	}

	protected abstract boolean isEnabled();

	protected String getSimpleName() {
		return this.annotationClass.getSimpleName();
	}

	protected Class<T> getAnnotationClass() {
		return this.annotationClass;
	}

	protected Environment getEnvironment() {
		return this.environment;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.beanClassLoader = classLoader;
	}
}
