package com.github.liblevenshtein.collection;

import java.util.Iterator;

/**
 * Implements boilerplate logic I typically use in my iterators.
 * @author Dylon Edwards
 * @param <Type> Type of the elements returned from this iterator.
 * @since 2.1.0
 */
public abstract class AbstractIterator<Type> implements Iterator<Type> {

  /**
   * Next value to return. The next element to return is determined via
   * {@link #advance()}
   */
  protected Type next = null;

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasNext() {
    advance();
    return next != null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Type next() {
    advance();
    final Type nextLocal = this.next;
    this.next = null;
    return nextLocal;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void remove() {
    throw new UnsupportedOperationException(
        "java.util.Iterator.remove() is not supported");
  }

  /**
   * Advances {@link #next} to the next, non-null value to return.
   */
  protected abstract void advance();
}
