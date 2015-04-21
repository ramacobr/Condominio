package com.sgc.models;

import java.io.Serializable;

/**
 * Interface base for Entities
 *
 */

public interface IEntity extends Serializable, Cloneable {

	public long getId();
}
