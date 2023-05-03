package gov.cms.madie.serviceutil.exceptions;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InternalServiceExceptionTest {

	@Test
	void test() {
		 InternalServerException thrown = Assertions.assertThrows(InternalServerException.class, () -> {
			 throw new InternalServerException("This is a error");
	  });
		  Assertions.assertEquals("This is a error", thrown.getMessage());
		 	
	}

}
