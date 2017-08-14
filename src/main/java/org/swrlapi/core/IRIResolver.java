package org.swrlapi.core;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLOntology;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * For simplicity, SWRL rule engine implementations will typically use the prefixed names of OWL entities to name
 * their representation of those objects. This interface provides resolving services for IRI to prefix name mapping
 * and vice versa.
 *
 * @see org.swrlapi.core.SWRLAPIOWLOntology
 */
public interface IRIResolver
{
  void reset();

  /**
   * @param prefixedName A prefixed name
   * @return The IRI resolved from the prefixed name
   */
  @NonNull Optional<@NonNull IRI> prefixedName2IRI(@NonNull String prefixedName);

  /**
   * @param variableName A variable name
   * @return The IRI created from the variable name
   */
  @NonNull Optional<@NonNull IRI> variableName2IRI(@NonNull String variableName);

  /**
   * @param iri An IRI
   * @return The prefixed form of the IRI
   */
  @NonNull Optional<@NonNull String> iri2PrefixedName(@NonNull IRI iri);

  /**
   * @param iri An IRI
   * @return A variable name form of the IRI
   */
  @NonNull Optional<@NonNull String> iri2VariableName(@NonNull IRI iri);

  /**
   * @param iri An OWL entity IRI
   * @return The short form of the IRI
   */
  @NonNull Optional<@NonNull String> iri2ShortForm(@NonNull IRI iri);

  /**
   * @param ontology The ontology from which to extract prefixes
   */
  void updatePrefixes(@NonNull OWLOntology ontology);

  /**
   * @param prefix    A prefix
   * @param namespace A namespace
   */
  void setPrefix(@NonNull String prefix, @NonNull String namespace);

  /**
   * @return A generated unique IRI
   */
  @NonNull IRI generateIRI();

  /**
   * Return a rendering of an OWL object
   *
   * @param owlObject The OWL object
   * @return Its rendering
   */
  @NonNull String render(@Nonnull OWLObject owlObject);
}
