package com.jsp.message.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="sms_template")
public class SmsTemplate {

		@Id
		@GenericGenerator(name="auto",strategy = "increment")
		@GeneratedValue(generator ="auto")
		@Column(name="alt_key")
		public long altKey;
		
		@Column(name="template_code")
		public String templateCode;

		@Column(name="entity_id")
		public String entityId;

		@Column(name="template_subject")
		public String templateSubject;

		@Column(name="template_content")
		public String templateContent;

		@Column(name="template_placeholder")
		public String templatePlaceholder;

		@Column(name="created_date")
		public Date createdDate;

		@Column(name="created_by")
		public String createdBy;
		
		@Column(name="modified_by")
		public String modifiedBy;

		@Column(name="modified_date")
		public Date modifiedDate;

		public String getTemplateCode() {
			return templateCode;
		}

		public void setTemplateCode(String templateCode) {
			this.templateCode = templateCode;
		}

		public String getEntityId() {
			return entityId;
		}

		public void setEntityId(String entityId) {
			this.entityId = entityId;
		}

		public String getTemplateSubject() {
			return templateSubject;
		}

		public void setTemplateSubject(String templateSubject) {
			this.templateSubject = templateSubject;
		}

		public String getTemplateContent() {
			return templateContent;
		}

		public void setTemplateContent(String templateContent) {
			this.templateContent = templateContent;
		}

		public String getTemplatePlaceholder() {
			return templatePlaceholder;
		}

		public void setTemplatePlaceholder(String templatePlaceholder) {
			this.templatePlaceholder = templatePlaceholder;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

		public Date getModifiedDate() {
			return modifiedDate;
		}

		public void setModifiedDate(Date modifiedDate) {
			this.modifiedDate = modifiedDate;
		}

	}


