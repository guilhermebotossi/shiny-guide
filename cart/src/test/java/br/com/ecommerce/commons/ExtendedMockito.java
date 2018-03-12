package br.com.ecommerce.commons;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.mockito.Mockito;

@SuppressWarnings({"unchecked"})
public class ExtendedMockito extends Mockito {
	
	public static <T> Set<T> mockSet(Class<T> clazz) {
		return (Set<T>) Mockito.mock(Set.class, Mockito.withSettings());
	}

	public static <T> List<T> mockList(Class<T> clazz) {
		return (List<T>) Mockito.mock(List.class, Mockito.withSettings());
	}

	public static <T> TypedQuery<T> mockTypedQuery(Class<T> clazz) {
		return (TypedQuery<T>) Mockito.mock(TypedQuery.class, Mockito.withSettings());
	}
}
