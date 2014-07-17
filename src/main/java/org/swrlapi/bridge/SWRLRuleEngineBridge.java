package org.swrlapi.bridge;

import java.util.List;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.swrlapi.builtins.arguments.SWRLBuiltInArgument;
import org.swrlapi.builtins.arguments.SWRLBuiltInArgumentFactory;
import org.swrlapi.core.*;
import org.swrlapi.exceptions.BuiltInException;
import org.swrlapi.exceptions.SWRLRuleEngineBridgeException;
import org.swrlapi.owl2rl.OWL2RLPersistenceLayer;

/**
 * A SWRL rule engine bridge defines the interface seen by a target implementation of a SWRL rule engine. The
 * implementation uses this interface primarily to supply axioms that it has inferred and to invoke built-ins.
 */
public interface SWRLRuleEngineBridge
{
	/**
	 * This method is used by a target rule engine to inform the bridge of its implementation.
	 */
	void setTargetRuleEngine(TargetRuleEngine targetRuleEngine);

	/**
	 * The infer methods are used by a target rule engines to put inferred axioms into the bridge.
	 */
	void inferOWLAxiom(OWLAxiom axiom) throws SWRLRuleEngineBridgeException;

	/**
	 * This method can be used by a target rule engine to invoke built-ins. If the built-in evaluates to false, an empty
	 * list is returned. If it evaluates to true, one of more argument lists are returned, one for each combination of
	 * arguments where the build-in predicate evaluates to true.
	 */
	List<List<SWRLBuiltInArgument>> invokeSWRLBuiltIn(String ruleName, String builtInName, int builtInIndex,
			boolean isInConsequent, List<SWRLBuiltInArgument> arguments) throws BuiltInException;

	/**
	 * A target rule engine can create OWL axioms using the OWL factory supplied by the bridge.
	 */
	SWRLAPIOWLDataFactory getSWRLAPIOWLDataFactory();

	SWRLAPIOWLDatatypeFactory getOWLDatatypeFactory();

	OWLLiteralFactory getOWLLiteralFactory();

	SWRLBuiltInArgumentFactory getSWRLBuiltInArgumentFactory();

	/**
	 * A named object resolver can be used by a target rule engine to determine the type of a named OWL entity given its
	 * URI or prefixed name. It can also be used to get the URI of an OWL named entity using its prefixed name.
	 */
	SWRLAPIIRIResolver getIRIResolver();

	/**
	 * A class expression resolver can be used by a target rule engine to resolve OWL class expressions.
	 */
	OWLClassExpressionResolver getOWLClassExpressionResolver();

	/**
	 * A class expression resolver can be used by a target rule engine to resolve OWL data ranges
	 */
	OWLDataRangeResolver getOWLDataRangeResolver();

	/**
	 * An object property expression resolver can be used by a target rule engine to resolve OWL property expressions.
	 */
	OWLObjectPropertyExpressionResolver getOWLObjectPropertyExpressionResolver();

	/**
	 * A data property expression resolver can be used by a target rule engine to resolve OWL property expressions.
	 */
	OWLDataPropertyExpressionResolver getOWLDataPropertyExpressionResolver();

	/**
	 * Get the underlying persistence layer for the OWL 2 RL reasoner used by the rule and query engine.
	 */
	OWL2RLPersistenceLayer getOWL2RLPersistenceLayer();

	/**
	 * See if the active ontology has changed since last knowledge rule engine call to {@link SWRLRuleEngine#reset()}.
	 */
	boolean hasOntologyChanged();
}
