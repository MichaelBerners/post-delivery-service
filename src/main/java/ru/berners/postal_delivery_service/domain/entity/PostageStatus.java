package ru.berners.postal_delivery_service.domain.entity;

/**
 * зарегестрированно
 * убыло из почтового отделения
 * прибыло в почтовое отделение
 * получено
 */
public enum PostageStatus {
    REGISTERED, HAS_LEFT_THE_POST_OFFICE, ARRIVED_AT_THE_POST_OFFICE, RECEIVED
}
