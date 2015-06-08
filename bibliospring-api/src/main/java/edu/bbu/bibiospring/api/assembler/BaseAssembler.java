package edu.bbu.bibiospring.api.assembler;

import edu.bbu.bibliospring.backend.model.BaseEntity;
import edu.bbu.bibliospring.common.dto.DataTransferObject;
import javax.ejb.Local;

/**
 *
 * @author zsvitalyos
 */

@Local
public interface BaseAssembler<D extends DataTransferObject, M extends BaseEntity>{
    M createModel ();
    D createDto ();
    D modelToDto (final M model);
    M dtoToModel (final D dto);
}
