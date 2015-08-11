# --- Created by Slick DDL
# --- !Ups

create table "user" ("userID" VARCHAR NOT NULL PRIMARY KEY,"firstName" VARCHAR,"lastName" VARCHAR,"fullName" VARCHAR,"email" VARCHAR,"avatarURL" VARCHAR);
create table "logininfo" ("id" BIGSERIAL NOT NULL PRIMARY KEY,"providerID" VARCHAR NOT NULL,"providerKey" VARCHAR NOT NULL);
create table "userlogininfo" ("userID" VARCHAR NOT NULL,"loginInfoId" BIGINT NOT NULL);
create table "passwordinfo" ("hasher" VARCHAR NOT NULL,"password" VARCHAR NOT NULL,"salt" VARCHAR,"loginInfoId" BIGINT NOT NULL);
create table "oauth1info" ("id" BIGSERIAL NOT NULL PRIMARY KEY,"token" VARCHAR NOT NULL,"secret" VARCHAR NOT NULL,"loginInfoId" BIGINT NOT NULL);
create table "oauth2info" ("id" BIGSERIAL  NOT NULL PRIMARY KEY,"accesstoken" VARCHAR NOT NULL,"tokentype" VARCHAR,"expiresin" INTEGER,"refreshtoken" VARCHAR,"logininfoid" BIGINT NOT NULL);
create table "openidinfo" ("id" VARCHAR NOT NULL PRIMARY KEY,"logininfoid" BIGINT NOT NULL);
create table "openidattributes" ("id" VARCHAR NOT NULL,"key" VARCHAR NOT NULL,"value" VARCHAR NOT NULL);
create table "countries" ("id" BIGSERIAL PRIMARY KEY,"name" VARCHAR(254) NOT NULL,"abbreviation" VARCHAR(254) NOT NULL,"continent" VARCHAR(254) NOT NULL,"image" VARCHAR(254) NOT NULL,"comment" text);
create unique index "idx_name" on "countries" ("name");
create table "eventTypes" ("id" BIGSERIAL PRIMARY KEY,"description" VARCHAR(254) NOT NULL,"comment" text);
create unique index "idx_description_EventType" on "eventTypes" ("description");
create table "events" ("id" BIGSERIAL PRIMARY KEY,"title" VARCHAR(254) NOT NULL,"dateEvent" DATE NOT NULL,"dateEndEvent" DATE NOT NULL,"countryId" BIGINT,"eventTypeId" BIGINT,"description" VARCHAR(254) NOT NULL,"comment" text);
create unique index "idx_title" on "events" ("title");
create table "indicator" ("id" BIGSERIAL PRIMARY KEY,"title" VARCHAR(254) NOT NULL,"description" VARCHAR(254) NOT NULL,"indicatorTypeId" BIGINT,"countryId" BIGINT,"comment" text);
create unique index "idx_description_indicator" on "indicator" ("title");
create table "indicatorTypes" ("id" BIGSERIAL PRIMARY KEY,"description" VARCHAR(254) NOT NULL,"comment" text);
create unique index "idx_description_Indicator" on "indicatorTypes" ("description");



# --- !Downs

drop table "openidattributes";
drop table "openidinfo";
drop table "oauth2info";
drop table "oauth1info";
drop table "passwordinfo";
drop table "userlogininfo";
drop table "logininfo";
drop table "user";
drop table "indicatorTypes";
drop table "indicator";
drop table "events";
drop table "eventTypes";
drop table "countries";
