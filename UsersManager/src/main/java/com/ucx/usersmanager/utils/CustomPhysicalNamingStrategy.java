/*
 * Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
 * Created by Arbër Pllana on 03/03/2022.
 */

package com.ucx.usersmanager.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * This is used by Hibernate to map database tables with POJO objects and it's attributes.
 */
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {
  @Override
  public Identifier toPhysicalCatalogName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalColumnName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalSchemaName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalSequenceName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return convertToSnakeCase(identifier);
  }

  @Override
  public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    return identifier;
  }

  private Identifier convertToSnakeCase(final Identifier identifier) {
    if (identifier == null) return null;

    final String regex = "([a-z])([A-Z])";
    final String replacement = "$1_$2";
    final String newName = identifier.getText()
            .replaceAll(regex, replacement)
            .toLowerCase();
    return Identifier.toIdentifier(newName);
  }
}
