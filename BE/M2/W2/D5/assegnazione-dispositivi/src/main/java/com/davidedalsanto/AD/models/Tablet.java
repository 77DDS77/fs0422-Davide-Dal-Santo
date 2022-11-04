package com.davidedalsanto.AD.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table(name = "tablets")
@Builder
@NoArgsConstructor
public class Tablet extends Device {

}
