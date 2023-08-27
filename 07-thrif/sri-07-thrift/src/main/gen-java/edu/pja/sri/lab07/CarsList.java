/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.pja.sri.lab07;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2022-07-01")
public class CarsList implements org.apache.thrift.TBase<CarsList, CarsList._Fields>, java.io.Serializable, Cloneable, Comparable<CarsList> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CarsList");

  private static final org.apache.thrift.protocol.TField CARS_FIELD_DESC = new org.apache.thrift.protocol.TField("cars", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CarsListStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CarsListTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.List<RentalCar> cars; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CARS((short)1, "cars");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CARS
          return CARS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CARS, new org.apache.thrift.meta_data.FieldMetaData("cars", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, RentalCar.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CarsList.class, metaDataMap);
  }

  public CarsList() {
  }

  public CarsList(
    java.util.List<RentalCar> cars)
  {
    this();
    this.cars = cars;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CarsList(CarsList other) {
    if (other.isSetCars()) {
      java.util.List<RentalCar> __this__cars = new java.util.ArrayList<RentalCar>(other.cars.size());
      for (RentalCar other_element : other.cars) {
        __this__cars.add(new RentalCar(other_element));
      }
      this.cars = __this__cars;
    }
  }

  public CarsList deepCopy() {
    return new CarsList(this);
  }

  @Override
  public void clear() {
    this.cars = null;
  }

  public int getCarsSize() {
    return (this.cars == null) ? 0 : this.cars.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<RentalCar> getCarsIterator() {
    return (this.cars == null) ? null : this.cars.iterator();
  }

  public void addToCars(RentalCar elem) {
    if (this.cars == null) {
      this.cars = new java.util.ArrayList<RentalCar>();
    }
    this.cars.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<RentalCar> getCars() {
    return this.cars;
  }

  public CarsList setCars(@org.apache.thrift.annotation.Nullable java.util.List<RentalCar> cars) {
    this.cars = cars;
    return this;
  }

  public void unsetCars() {
    this.cars = null;
  }

  /** Returns true if field cars is set (has been assigned a value) and false otherwise */
  public boolean isSetCars() {
    return this.cars != null;
  }

  public void setCarsIsSet(boolean value) {
    if (!value) {
      this.cars = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case CARS:
      if (value == null) {
        unsetCars();
      } else {
        setCars((java.util.List<RentalCar>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case CARS:
      return getCars();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case CARS:
      return isSetCars();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof CarsList)
      return this.equals((CarsList)that);
    return false;
  }

  public boolean equals(CarsList that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_cars = true && this.isSetCars();
    boolean that_present_cars = true && that.isSetCars();
    if (this_present_cars || that_present_cars) {
      if (!(this_present_cars && that_present_cars))
        return false;
      if (!this.cars.equals(that.cars))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetCars()) ? 131071 : 524287);
    if (isSetCars())
      hashCode = hashCode * 8191 + cars.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(CarsList other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetCars()).compareTo(other.isSetCars());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCars()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cars, other.cars);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("CarsList(");
    boolean first = true;

    sb.append("cars:");
    if (this.cars == null) {
      sb.append("null");
    } else {
      sb.append(this.cars);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CarsListStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CarsListStandardScheme getScheme() {
      return new CarsListStandardScheme();
    }
  }

  private static class CarsListStandardScheme extends org.apache.thrift.scheme.StandardScheme<CarsList> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CarsList struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CARS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.cars = new java.util.ArrayList<RentalCar>(_list0.size);
                @org.apache.thrift.annotation.Nullable RentalCar _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new RentalCar();
                  _elem1.read(iprot);
                  struct.cars.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setCarsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CarsList struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.cars != null) {
        oprot.writeFieldBegin(CARS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.cars.size()));
          for (RentalCar _iter3 : struct.cars)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CarsListTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CarsListTupleScheme getScheme() {
      return new CarsListTupleScheme();
    }
  }

  private static class CarsListTupleScheme extends org.apache.thrift.scheme.TupleScheme<CarsList> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CarsList struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetCars()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetCars()) {
        {
          oprot.writeI32(struct.cars.size());
          for (RentalCar _iter4 : struct.cars)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CarsList struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.cars = new java.util.ArrayList<RentalCar>(_list5.size);
          @org.apache.thrift.annotation.Nullable RentalCar _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new RentalCar();
            _elem6.read(iprot);
            struct.cars.add(_elem6);
          }
        }
        struct.setCarsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
