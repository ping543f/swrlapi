package org.swrlapi.factory;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.Deterministic;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.swrlapi.literal.OWLLiteralComparator;
import org.swrlapi.sqwrl.exceptions.SQWRLException;
import org.swrlapi.sqwrl.values.SQWRLAnnotationPropertyResultValue;
import org.swrlapi.sqwrl.values.SQWRLClassExpressionResultValue;
import org.swrlapi.sqwrl.values.SQWRLClassResultValue;
import org.swrlapi.sqwrl.values.SQWRLDataPropertyExpressionResultValue;
import org.swrlapi.sqwrl.values.SQWRLDataPropertyResultValue;
import org.swrlapi.sqwrl.values.SQWRLDataRangeResultValue;
import org.swrlapi.sqwrl.values.SQWRLDatatypeResultValue;
import org.swrlapi.sqwrl.values.SQWRLEntityResultValue;
import org.swrlapi.sqwrl.values.SQWRLExpressionResultValue;
import org.swrlapi.sqwrl.values.SQWRLIndividualResultValue;
import org.swrlapi.sqwrl.values.SQWRLLiteralResultValue;
import org.swrlapi.sqwrl.values.SQWRLNamedIndividualResultValue;
import org.swrlapi.sqwrl.values.SQWRLObjectPropertyExpressionResultValue;
import org.swrlapi.sqwrl.values.SQWRLObjectPropertyResultValue;

import java.util.Comparator;

class DefaultSQWRLLiteralResultValue extends DefaultLiteral implements SQWRLLiteralResultValue
{
  private static final Comparator<@NonNull OWLLiteral> owlLiteralComparator = OWLLiteralComparator.COMPARATOR;

  private final String datatypePrefixedName;

  public DefaultSQWRLLiteralResultValue(@NonNull OWLLiteral literal, @NonNull String datatypePrefixedName)
  {
    super(literal);
    this.datatypePrefixedName = datatypePrefixedName;
  }

  @Override public String getDatatypePrefixedName()
  {
    return this.datatypePrefixedName;
  }

  @Override public boolean isLiteral()
  {
    return true;
  }

  @NonNull @Override public SQWRLLiteralResultValue asLiteralResult()
  {
    return this;
  }

  @Override public boolean isEntity()
  {
    return false;
  }

  @Override public boolean isExpression()
  {
    return false;
  }

  @Override public boolean isClass()
  {
    return false;
  }

  @Override public boolean isClassExpression()
  {
    return false;
  }

  @Override public boolean isIndividual()
  {
    return false;
  }

  @Override public boolean isNamedIndividual()
  {
    return false;
  }

  @Override public boolean isObjectProperty()
  {
    return false;
  }

  @Override public boolean isObjectPropertyExpression()
  {
    return false;
  }

  @Override public boolean isDataProperty()
  {
    return false;
  }

  @Override public boolean isDataPropertyExpression()
  {
    return false;
  }

  @Override public boolean isAnnotationProperty()
  {
    return false;
  }

  @Override public boolean isDatatype()
  {
    return false;
  }

  @Override public boolean isDataRange()
  {
    return false;
  }

  @NonNull @Override public SQWRLEntityResultValue asEntityResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not a " + SQWRLEntityResultValue.class.getName());
  }

  @NonNull @Override public SQWRLExpressionResultValue asExpressionResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not a " + SQWRLExpressionResultValue.class.getName());
  }

  @NonNull @Override public SQWRLClassResultValue asClassResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not a " + SQWRLClassResultValue.class.getName());
  }

  @NonNull @Override public SQWRLClassExpressionResultValue asClassExpressionResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not a " + SQWRLClassExpressionResultValue.class.getName());
  }

  @NonNull @Override public SQWRLNamedIndividualResultValue asNamedIndividualResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not a " + SQWRLNamedIndividualResultValue.class.getName());
  }

  @NonNull @Override public SQWRLIndividualResultValue asIndividualResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not a " + SQWRLIndividualResultValue.class.getName());
  }

  @NonNull @Override public SQWRLObjectPropertyResultValue asObjectPropertyResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not an " + SQWRLObjectPropertyResultValue.class.getName());
  }

  @NonNull @Override public SQWRLObjectPropertyExpressionResultValue asObjectPropertyExpressionResult()
    throws SQWRLException
  {
    throw new SQWRLException(
      getClass().getName() + " is not an " + SQWRLObjectPropertyExpressionResultValue.class.getName());
  }

  @NonNull @Override public SQWRLDataPropertyResultValue asDataPropertyResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not an " + SQWRLDataPropertyResultValue.class.getName());
  }

  @NonNull @Override public SQWRLDataPropertyExpressionResultValue asDataPropertyExpressionResult()
    throws SQWRLException
  {
    throw new SQWRLException(
      getClass().getName() + " is not an " + SQWRLDataPropertyExpressionResultValue.class.getName());
  }

  @NonNull @Override public SQWRLAnnotationPropertyResultValue asAnnotationPropertyResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not an " + SQWRLAnnotationPropertyResultValue.class.getName());
  }

  @NonNull @Override public SQWRLDatatypeResultValue asDatatypeResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not a " + SQWRLDatatypeResultValue.class.getName());
  }

  @NonNull @Override public SQWRLDataRangeResultValue asDataRangeResult() throws SQWRLException
  {
    throw new SQWRLException(getClass().getName() + " is not a " + SQWRLDataRangeResultValue.class.getName());
  }

  @SideEffectFree @Deterministic @Override public boolean equals(@Nullable Object obj)
  {
    if (this == obj)
      return true;
    if ((obj == null) || (obj.getClass() != this.getClass()))
      return false;
    DefaultSQWRLLiteralResultValue l = (DefaultSQWRLLiteralResultValue)obj;

    return owlLiteralComparator.compare(this.getOWLLiteral(), l.getOWLLiteral()) == 0;
  }

  @SideEffectFree @Deterministic @Override public int hashCode()
  {
    int hash = 98;
    hash = hash + (null == this.getOWLLiteral() ? 0 : this.getOWLLiteral().hashCode());
    return hash;
  }

  @SideEffectFree @Deterministic @Override public int compareTo(@NonNull SQWRLLiteralResultValue o)
  {
    if (o == null)
      throw new NullPointerException();

    return owlLiteralComparator.compare(this.getOWLLiteral(), o.getOWLLiteral());
  }
}
