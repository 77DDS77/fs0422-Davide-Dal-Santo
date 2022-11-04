package com.davidedalsanto.AD.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "laptops")
@SuperBuilder
@Builder
@NoArgsConstructor
public class Laptop extends Device{

}
