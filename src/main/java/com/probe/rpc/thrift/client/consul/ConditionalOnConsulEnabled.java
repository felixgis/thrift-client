package com.probe.rpc.thrift.client.consul;

import java.lang.annotation.*;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;

import com.ecwid.consul.v1.ConsulClient;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Conditional(ConditionalOnConsulEnabled.OnConsulEnabledCondition.class)
public @interface ConditionalOnConsulEnabled {

	class OnConsulEnabledCondition extends AllNestedConditions {

		public OnConsulEnabledCondition() {
			super(ConfigurationPhase.REGISTER_BEAN);
		}

		@ConditionalOnProperty(value = "spring.consul.enabled", matchIfMissing = true)
		static class FoundProperty {
		}

		@ConditionalOnClass(ConsulClient.class)
		static class FoundClass {
		}
	}
}
