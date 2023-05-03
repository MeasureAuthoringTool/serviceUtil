package gov.cms.madie.serviceutil.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Measure;
import org.hl7.fhir.r4.model.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gov.cms.madie.serviceutil.exceptions.InternalServerException;

class ResourceUtilsTest {

	@Test
	void testGetData() {
		String results = ResourceUtils.getData("/test-cql/cv_populations.cql");
		assertNotNull(results);
		assertEquals("library TestCVPopulations", results.substring(0, 25) );
	}
	
	@Test
	void testGetData_UnableToFetchResource() {
		
		InternalServerException thrown = Assertions.assertThrows(InternalServerException.class, () -> {
			ResourceUtils.getData("/test-cql/missing_file.cql");
			 
	  });
		  Assertions.assertEquals("Unable to fetch resource /test-cql/missing_file.cql", thrown.getMessage());

	}
	
	@Test
	void testGetData_NullResource() {
		
		InternalServerException thrown = Assertions.assertThrows(InternalServerException.class, () -> {
			ResourceUtils.getData(null);
			 
	  });
		  Assertions.assertEquals("Resource name cannot be null", thrown.getMessage());

	}
	
	@Test
	void testGetResource() {
	    Bundle bundle = new Bundle();
	    Measure measureResource = new Measure();
	    Bundle.BundleEntryComponent bundleEntryComponent = bundle.addEntry();
	    bundleEntryComponent.setResource(measureResource);
	    
	    Resource resource = ResourceUtils.getResource(bundle, "Measure");
	    
	    assertNotNull(resource);
	    
	}
	
	@Test
	void testGetResource_nullBundle() {
	    
	    
	    Resource resource = ResourceUtils.getResource(null, "measure");
	    
	    assertNull(resource);
	    
	}
	
	@Test
	void testGetResource_nullResourceType() {
	    Bundle bundle = new Bundle();
	    Measure measureResource = new Measure();
	    Bundle.BundleEntryComponent bundleEntryComponent = bundle.addEntry();
	    bundleEntryComponent.setResource(measureResource);
	    
	    Resource resource = ResourceUtils.getResource(bundle, null);
	    
	    assertNull(resource);
	    
	}

}
