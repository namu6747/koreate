package test;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Collectors.CollectorImpl;

import effectivejava.chapter6.item37.Phase;
import effectivejava.chapter6.item37.Phase.Transition;

public class any2 {

	public static void main(String[] args) {
		
		
		
		public static <T, K, D, A, M extends Map<K, D>>
	    Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
	                                  Supplier<M> mapFactory,
	                                  Collector<? super T, A, D> downstream) {
	        Supplier<A> downstreamSupplier = downstream.supplier();
	        BiConsumer<A, ? super T> downstreamAccumulator = downstream.accumulator();
	        BiConsumer<Map<K, A>, T> accumulator = (m, t) -> {
	            K key = Objects.requireNonNull(classifier.apply(t), "element cannot be mapped to a null key");
	            A container = m.computeIfAbsent(key, k -> downstreamSupplier.get());
	            downstreamAccumulator.accept(container, t);
	        };
	        BinaryOperator<Map<K, A>> merger = Collectors.<K, A, Map<K, A>>mapMerger(downstream.combiner());
	        @SuppressWarnings("unchecked")
	        Supplier<Map<K, A>> mangledFactory = (Supplier<Map<K, A>>) mapFactory;

	        if (downstream.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
	            return new CollectorImpl<>(mangledFactory, accumulator, merger, CH_ID);
	        }
	        else {
	            @SuppressWarnings("unchecked")
	            Function<A, A> downstreamFinisher = (Function<A, A>) downstream.finisher();
	            Function<Map<K, A>, M> finisher = intermediate -> {
	                intermediate.replaceAll((k, v) -> downstreamFinisher.apply(v));
	                @SuppressWarnings("unchecked")
	                M castResult = (M) intermediate;
	                return castResult;
	            };
	            return new CollectorImpl<>(mangledFactory, accumulator, merger, finisher, CH_NOID);
	        }
	    }
		
		private static final 
			Map<Phase, Map<Phase, Transition>>		// 중첩 맵
			m = Stream.of(values())					// Transition[] a = { Transition.MELT, Transition.FREEZE, . . .}
			.collect(								//
			groupingBy(								//return ColletorImpl
			t -> t.from,							//Function(classifier)//
			() -> new EnumMap<>(Phase.class),		//Supplier(MapFactory)//
			// .collect(groupingBy(a,b,toMap(c,d,e,f)))
			toMap(t -> t.to,						//Collector(downstream)//Function(KeyMapper)
					t -> t,							//Funtion(valueMapper)
			(x, y) -> y,							//BinaryOperator(mergeFunction)
			() -> new EnumMap<>(Phase.class))));	//Supplier(MapFactory)

	}

}
